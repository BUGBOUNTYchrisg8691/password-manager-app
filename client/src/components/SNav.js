import React from 'react';
import SideNav, {
  Toggle,
  Nav,
  NavItem,
  NavIcon,
  NavText,
} from '@trendmicro/react-sidenav';

export default function SNav() {
  return (
    <SideNav onSelect={(selected) => {}}>
      <SideNav.Toggle />
      <SideNav.Nav defaultSelected="home">
        <NavItem eventKey="home">
          <NavIcon>
            <i className="fa fa-fw fa-home" style={{ fontSize: '1.75em' }} />
          </NavIcon>
          <NavText>Home</NavText>
        </NavItem>
        <NavItem eventKey="storage">
          <NavIcon>
            <i className="fa fa-fw fa-archive" style={{ fontSize: '1.75em' }} />
          </NavIcon>
          <NavText>Storage</NavText>
          <NavItem eventKey="storage/search">
            <NavText>Search</NavText>
          </NavItem>
          <NavItem eventKey="storage/add">
            <NavText>Add</NavText>
          </NavItem>
        </NavItem>
      </SideNav.Nav>
    </SideNav>
  );
}
